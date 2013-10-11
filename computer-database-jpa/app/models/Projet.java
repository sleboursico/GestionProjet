package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import models.enums.EnumStatut;
import play.data.validation.Constraints;
import play.db.jpa.JPA;

/**
 * Company entity managed by JPA
 */
@Entity
public class Projet {

	@Id
	public Long id;

	@Constraints.Required
	public String name;

	public String url;

	public EnumStatut statut;

	public static Projet findById(Long id) {
		return JPA.em().find(Projet.class, id);
	}

	/**
	 * Return a page of computer
	 * 
	 * @param page
	 *            Page to display
	 * @param pageSize
	 *            Number of computers per page
	 * @param sortBy
	 *            Computer property used for sorting
	 * @param order
	 *            Sort order (either or asc or desc)
	 * @param filter
	 *            Filter applied on the name column
	 */
	public static Page<Projet> page(int page, int pageSize, String sortBy,
			String order, String filter) {
		if (page < 1)
			page = 1;
		Long total = (Long) JPA
				.em()
				.createQuery(
						"select count(c) from Projet c where lower(c.name) like ?")
				.setParameter(1, "%" + filter.toLowerCase() + "%")
				.getSingleResult();
		@SuppressWarnings("unchecked")
		List<Projet> data = JPA
				.em()
				.createQuery(
						"from Projet c where lower(c.name) like ? order by c."
								+ sortBy + " " + order)
				.setParameter(1, "%" + filter.toLowerCase() + "%")
				.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize)
				.getResultList();
		return new Page<Projet>(data, total, page, pageSize);
	}

}
