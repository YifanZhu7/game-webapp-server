package com.example.gamewebappserver.repositories;

import com.example.gamewebappserver.models.Friend;
import com.example.gamewebappserver.models.Game;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FriendRepository
    extends CrudRepository<Friend, Integer>{
    @Query("select friend from Friend friend where friend.user.id=:userId")
    public List<Friend> findFriendForUser(
        @Param("userId") Integer id
    );

}
