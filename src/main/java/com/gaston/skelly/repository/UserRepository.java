package com.gaston.skelly.repository;


import com.gaston.skelly.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    /*********
     * Some supported mongo queries
     *  count, delete, deleteAll, deleteAll,
     *  deleteById, existsById, findAllById,
     *  findById, save
     ********/

    /**
     * Query for a user in the database by email
     * @param email
     * @return User
     */
    User findOneByEmail(String email);

    User findOneById(String id);
}
