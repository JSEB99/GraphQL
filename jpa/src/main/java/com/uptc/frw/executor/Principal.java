package com.uptc.frw.executor;

import com.uptc.frw.conf.PersistenceUtil;
import com.uptc.frw.models.Client;
import com.uptc.frw.models.Modification;
import com.uptc.frw.models.Repair;
import jakarta.persistence.EntityManager;

import java.util.Date;

public class Principal {
    public static void main(String[] args) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Client client = em.getReference(Client.class,2);
        System.out.println(client.getRepairs());
    }

    public static void createClient(){
        EntityManager em = PersistenceUtil.getEntityManager();
        Client client = new Client();
        client.setName("Pepito Perez");
        client.setDocument(1049653501);
        client.setAddress("Calle 1ra esquina");
        client.setPhone(555000333);
        client.setEmail("pepito.perez@algo.com.co");
        em.persist(client);
        em.getTransaction().begin();
        em.getTransaction().commit();
    }
    public static void createModification(){
        EntityManager em = PersistenceUtil.getEntityManager();
        Modification modification = new Modification();
        modification.setDescription("Prueba1");
        modification.setIdComponent(1);
        em.persist(modification);
        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();
    }
}
