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
            //update student object
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
    public void delete(int id){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            //start transaction
            transaction = session.beginTransaction();
            //delete user object
       User user =session.get(User.class, id);
       if(user != null){
           session.delete(user);
           System.out.println("User is deleted");
       }
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
