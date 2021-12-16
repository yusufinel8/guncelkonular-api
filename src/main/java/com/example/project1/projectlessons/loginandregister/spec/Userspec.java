package com.example.project1.projectlessons.loginandregister.spec;

import com.example.project1.projectlessons.loginandregister.entity.Userentity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;

public class Userspec implements Specification<Userentity> {

    private Userentity filtre;

    public Userspec(Userentity filter) {
        super();
        this.filtre = filter;
    }

    @Override
    public Predicate toPredicate(Root<Userentity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate p = criteriaBuilder.disjunction();
        return p;
    }
    public static Specification<Userentity> findByFilter(Userentity filter) {
        return (root, query, criteriaBuilder) -> {
            Predicate p = criteriaBuilder.disjunction();
            List<Predicate> predicateList = new ArrayList<>();
            if (filter != null) {
                if (filter.getUser_name() != null) {
                    predicateList.add(criteriaBuilder.greaterThan(root.get("id"), filter.getUser_name()));
                }
                if (filter.getFiles() != null) {
                    //predicateList.add(criteriaBuilder.equal(root.get("firstname"), filter.getFirstname()));
                    predicateList.add(criteriaBuilder.like(root.get("firstname"), "%" + filter.getFiles() + "%"));
                }
                if (filter.getUsers_id() != null) {
                    predicateList.add(criteriaBuilder.equal(root.get("lastname"), filter.getUsers_id()));
                }
                if (filter.getPasword() != null) {
                    predicateList.add(criteriaBuilder.equal(root.get("age"), filter.getPasword()));
                }
                if(filter.getEmail()!=null){
                    //  predicateList.add(criteriaBuilder.between())
                }

                /* gelen id ye göre büyükleri getiren kod
                  if (filter.getId() != null) {
                    predicateList.add(criteriaBuilder.greaterThan(root.get("id"), filter.getId()));
                }
                 gelen id ye göre küçükleri getiren kod
                *   if (filter.getId() != null) {
                    predicateList.add(criteriaBuilder.lessThan(root.get("id"), filter.getId()));
                }
                * */

            }
            p.getExpressions().add(criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()])));
            return p;
        };
    }
}
