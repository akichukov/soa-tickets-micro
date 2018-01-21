package mk.ukim.finki.soaticketssearch.business.services.implementation;

import mk.ukim.finki.soaticketssearch.business.services.ISearchService;
import mk.ukim.finki.soaticketssearch.business.view.models.UserViewModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService implements ISearchService {
    @Override
    public List<UserViewModel> searchUsers(String searchTerm) {
//        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
//        QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(User.class).get();
//        Query luceneQuery = qb.keyword().fuzzy().withEditDistanceUpTo(2).withPrefixLength(1).onFields("firstName", "lastName", "email", "phoneNumber", "ownedEvents.name")
//                .matching(searchTerm).createQuery();
//
//        javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, User.class);
//
//        // execute search
//
//        List<User> usersList = null;
//        List<UserViewModel> mappedUsersList = new ArrayList<>();
//        try {
//            usersList = jpaQuery.getResultList();
//            for (User user : usersList){
//                mappedUsersList.add(modelMapper.map(user, UserViewModel.class));
//            }
//        } catch (NoResultException nre) {
//            ;// do nothing
//            throw nre;
//        }
//
//        return mappedUsersList;
        return new ArrayList<>();
    }
}
