package team1.funddigging.domain.repository

import ...
public interface UserRepository extends JpaRepository <User, Long> {
    @Query("select r from User r where r.accessToken = :token")
    User findByUserToken(String token);
}