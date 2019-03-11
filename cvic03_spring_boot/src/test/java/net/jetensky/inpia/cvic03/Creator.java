package net.jetensky.inpia.cvic03;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Creator {

    Log log = LogFactory.getLog(Creator.class);

    @Autowired
    private ApplicationContext applicationContext;


    public void save(Object... entities) {
        for (Object entity : entities) {
            save(entity);
        }
    }

    public Object save(Object entity) {
        try {
            Map props = PropertyUtils.describe(entity);
            List<Field> allFields = FieldUtils.getAllFieldsList(entity.getClass());
            for (Field field : allFields) {
                try {
                    field.setAccessible(true);
                    Object propValue = FieldUtils.readField(field, entity);
                    final boolean notEmptyField = fieldHasAnnotation(field, NotEmpty.class);
                    boolean manyToOne = fieldHasAnnotation(field, ManyToOne.class);;
                    if ((propValue ==null) && (notEmptyField || manyToOne)) {
                        if (field.getType().isAssignableFrom(String.class)) {
                                propValue = "Test " + field.getName();
                        } else {
                            propValue = field.getType().newInstance();
                        }
                        PropertyUtils.setProperty(entity, field.getName(), propValue);

                    }
                    saveChildEntity(propValue);
                } catch (IllegalAccessException e) {
                    log.info("Skipping " + field.getName() + ", as it is probably private");
                }
            }

            for (Object propName : props.keySet()) {
                Object propValue = props.get(propName);
                saveChildEntity(propValue);
            }

            getDao(entity).save(entity);
        } catch (Exception e) {
            throw new IllegalStateException("Problem", e);
        }
        return entity;

    }

    private boolean fieldHasAnnotation(Field field, Class annotationClass) {
        return field.getDeclaredAnnotationsByType(annotationClass).length > 0;
    }

    private JpaRepository getDao(Object entity) {
        String repoClassName = entity.getClass().getSimpleName();
        String repositoryBeanName = repoClassName.substring(0,1).toLowerCase() + repoClassName.substring(1) + "Repository";
        return (JpaRepository) applicationContext.getBean(repositoryBeanName);
    }


    private void saveChildEntity(Object propValue) {
        if (propValue!=null)  {
            Class<?> valueClass = propValue.getClass();
            final boolean isEntity = isEntity(valueClass);
            if ((isEntity)) {

                save(propValue);
                String className = propValue.getClass().getSimpleName();
                String daoName = className.substring(0,1).toLowerCase() + className.substring(1) + "Repository";

                JpaRepository jpaRepository = applicationContext.getBeansOfType(JpaRepository.class).get(daoName);
                jpaRepository.save(propValue);
            }
        }
    }

    private boolean isEntity(Class<?> valueClass) {
        return valueClass.getDeclaredAnnotationsByType(Entity.class).length > 0;
    }

}


