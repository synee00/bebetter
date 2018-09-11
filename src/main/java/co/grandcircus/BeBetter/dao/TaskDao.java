package co.grandcircus.BeBetter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.BeBetter.Entity.Task;

@Repository
@Transactional
public class TaskDao {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Task> findAll() {
		return em.createQuery("FROM Task", Task.class).getResultList();
	}
	
	public void create(Task task) {
		em.persist(task);
	}
	//delete
	public void delete(Long id) {
		Task task = em.getReference(Task.class, id);
		em.remove(task);
	}
	
	//complete
	public void complete(Long id, Boolean complete) {
		System.out.println("Check " + id + " " + complete);
		Task task = em.find(Task.class, id);
		task.setComplete(complete);
	}
//	edit
//	public Task findById(Long id) {
//		return em.find(Task.class,  id);
//	}
	
}
