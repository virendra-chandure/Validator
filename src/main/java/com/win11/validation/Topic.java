package com.win11.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE,
		ElementType.LOCAL_VARIABLE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TopicValidator.class)
@Documented
public @interface Topic {
	// String message() default "must be a valid topic." + " found:
	// ${validatedValue}";
	String message() default "must be a valid topic or name or description within allowed limit.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}