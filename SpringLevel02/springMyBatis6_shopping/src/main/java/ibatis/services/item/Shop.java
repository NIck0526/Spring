package ibatis.services.item;



import java.util.List;

import ibatis.services.domain.Item;

public interface Shop {
	
	List<Item> findItemList();
	
	Item findPrimaryKey(int	itemId) throws Exception;
}
