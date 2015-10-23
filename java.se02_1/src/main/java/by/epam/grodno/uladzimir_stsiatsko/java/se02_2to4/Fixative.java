package by.epam.grodno.uladzimir_stsiatsko.java.se02_2to4;

import java.util.List;

/**
 * Fixative interface for stapling papers.
 * 
 * @author Uladzimir Stsiatsko
 *
 */
public interface Fixative {

	public List<Paper> staple(Paper... papers);

}
