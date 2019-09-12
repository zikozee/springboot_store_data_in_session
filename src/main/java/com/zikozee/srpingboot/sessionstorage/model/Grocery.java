package com.zikozee.srpingboot.sessionstorage.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter @Setter @ToString @EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Grocery {

    @EqualsAndHashCode.Include
    private String customerName;

    private String groceryItem;

    public void setGroceryItem(String groceryItem){// this>> th:field="*{groceryItem} is called automatically in thymeleaf
        if(CollectionUtils.isEmpty(groceryList)){
            List<String> newGroceryList = new ArrayList<>();
            newGroceryList.add(groceryItem);
            setGroceryList(newGroceryList);
        }else{
            getGroceryList().add(groceryItem);
        }
    }

    @EqualsAndHashCode.Include
    private List<String> groceryList;

}
