package by.epam.grodno.uladzimir_stsiatsko.java.se02_6and7;

import java.lang.annotation.*;

@Documented
@Target(value=ElementType.TYPE)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface specialNote {
	
	String startNote();
	String stopNote();

}
