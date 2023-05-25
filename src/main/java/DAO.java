/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import jakarta.persistence.*;
import java.util.List;

public class DAO<T> {
    private EntityManager em;
    private EntityTransaction et;
    final Class<T> type;
    
    public DAO(final Class<T> type, EntityManager em) {
        this.em = em;
        this.et = em.getTransaction();
        this.type = type;
    }
    public void insert(T item) {
        et.begin();
        em.persist(item);
        et.commit();
        System.out.println("Inserting " + item.toString() + "\n");
    }
    public T update(T item) {
        et.begin();
        T ret = em.merge(item);
        et.commit();
        System.out.println("Updating " + item.toString() + "\n");
        return ret;
    }
    public void delete(T item) {
        et.begin();
        em.remove(item);
        et.commit();
        System.out.println("Deleting " + item.toString() + "\n");
    }
    public T get(int id) {
        et.begin();
        T item = em.find(this.type, id);
        et.commit();
        if (item == null)
            System.out.println("Item not found");
        else
            System.out.println(item);
        return item;
    }
    public List<T> getItems() {
        System.out.println("SELECT b FROM " + type.getSimpleName() + " AS b");
        TypedQuery qq = em.createQuery("SELECT b FROM " + type.getSimpleName() + " AS b", type);
        List<T> ll = qq.getResultList();
        for (T bb : ll)
            System.out.println(bb);
        System.out.println();
        return ll;
    }
    public List<T> getItemsByValue(String columnName, String value) {
        System.out.println("SELECT b FROM " + type.getSimpleName() + " AS b "
                + "WHERE (b." + columnName + "=:val)");
        TypedQuery qq = em.createQuery("SELECT b FROM " + type.getSimpleName() + " AS b "
                + "WHERE (b." + columnName + "=:val)", type);
        qq.setParameter("val", value);
        List<T> ll = qq.getResultList();
        for (T bb : ll)
            System.out.println(bb);
        System.out.println();
        return ll;
    }

//    public List<Object[]> query1() {
//        System.out.println("SELECT a.title, a.release_date, ar.artistname\n" +
//                "FROM Album a\n" +
//                "LEFT OUTER JOIN Artist ar ON a.artist = ar.artistID");
//
//        TypedQuery<Object[]> query = em.createQuery(
//                "SELECT a.title, a.release_date, ar.artistname " +
//                        "FROM Album a " +
//                        "LEFT OUTER JOIN Artist ar ON a.artist = ar.artistID", Object[].class);
//
//        List<Object[]> resultList = query.getResultList();
//        for (Object[] result : resultList) {
//            System.out.println("Title: " + result[0] + ", Release Date: " + result[1] + ", Artist Name: " + result[2]);
//        }
//    System.out.println();
//        return resultList;
//    }
//
//    public List<Object[]> query2() {
//        System.out.println("SELECT s.title, s.language, g.description\n" +
//                "FROM Song s\n" +
//                "INNER JOIN Genre g ON s.genre = g.name\n" +
//                "WHERE g.name = 'Rock'");
//
//        TypedQuery<Object[]> query = em.createQuery(
//                "SELECT s.title, s.language, g.description " +
//                        "FROM Song s " +
//                        "INNER JOIN Genre g ON s.genre = g.name " +
//                        "WHERE g.name = 'Rock'", Object[].class);
//
//        List<Object[]> resultList = query.getResultList();
//        for (Object[] result : resultList) {
//            System.out.println("Title: " + result[0] + ", Language: " + result[1] + ", Description: " + result[2]);
//        }
//        System.out.println();
//        return resultList;
//    }
//
//    public List<Object[]> query3() {
//        System.out.println("SELECT ar.artistname, al.title, al.release_date\n" +
//                "FROM Album al\n" +
//                "INNER JOIN Artist ar ON al.artist = ar.artistID\n" +
//                "WHERE al.release_date BETWEEN '2022-01-01' AND '2022-12-31'");
//
//        TypedQuery<Object[]> query = em.createQuery(
//                "SELECT ar.artistname, al.title, al.release_date " +
//                        "FROM Album al " +
//                        "INNER JOIN Artist ar ON al.artist = ar.artistID " +
//                        "WHERE al.release_date BETWEEN '2022-01-01' AND '2022-12-31'", Object[].class);
//
//        List<Object[]> resultList = query.getResultList();
//        for (Object[] result : resultList) {
//            System.out.println("Artist Name: " + result[0] + ", Album Title: " + result[1] + ", Release Date: " + result[2]);
//        }
//        System.out.println();
//        return resultList;
//    }
}
