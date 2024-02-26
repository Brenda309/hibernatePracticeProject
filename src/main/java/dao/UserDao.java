package dao;


import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

//CRUD operations
public class UserDao {
//    save user;
//    @param user

    public void saveUser(User user){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            //start transaction
            transaction = session.beginTransaction();
            //save student object
            session.save(user);
            // commit trans
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }


    }

    /**
     * Update User
     * @param user
     */
    public void updateUser(User user){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            //start transaction
            transaction = session.beginTransaction();
            //save student object
            session.update(user);
            // commit trans
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }


    }

}
