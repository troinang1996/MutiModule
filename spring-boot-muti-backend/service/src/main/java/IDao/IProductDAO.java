package IDao;

import java.util.List;

public interface IProductDAO<L,K> extends IGeneralDAO<L,K>{
    List<L> findByKeywords(String keywords);
    List<L> findByCategoryId(Integer id);
    List<L> findItemByHot(String key);
    List<L> findByIdsInCookie(String id);
}
