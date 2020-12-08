package eu.fade.jpa.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("employees");
    private EntityManager em = emf.createEntityManager();


    public List<Employee> queryEmployees(String queryString) {

        TypedQuery<Employee> query = em.createQuery(queryString, Employee.class);

        return query.getResultList();
    }

    public Employee findEmployee(String queryString) {

        TypedQuery<Employee> query = em.createQuery(queryString, Employee.class);

        return query.getSingleResult();
    }

    public Double getAverage(String queryString) {
        TypedQuery<Double> query = em.createQuery(queryString, Double.class);

        return query.getSingleResult();
    }

    public List<Object[]> getGroupedBy(String queryString) {
        TypedQuery<Object[]> query = em.createQuery(queryString, Object[].class);

        return query.getResultList();
    }

    public List<Name> getListOfNames() {
        TypedQuery<Name> query = em.createQuery("select new eu.fade.jpa.domain.Name(e.firstName, e.lastName) from Employee e", Name.class);

        return query.getResultList();
    }
}
