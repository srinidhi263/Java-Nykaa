package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String userName;
    private String pwd;
    private String email;
    private Cart cart;
    private ArrayList<OrderHistory> orderHistories = new ArrayList<>();
}
