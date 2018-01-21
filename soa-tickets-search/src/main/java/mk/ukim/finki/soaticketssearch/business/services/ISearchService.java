package mk.ukim.finki.soaticketssearch.business.services;

import mk.ukim.finki.soaticketssearch.business.view.models.UserViewModel;

import java.util.List;

public interface ISearchService {
    List<UserViewModel> searchUsers(String searchTerm);
}
