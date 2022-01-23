package project.nft.nft.services;

import java.util.Collection;

public interface CollectionService {
    Collection<project.nft.nft.models.Collection> list(int limit, int page);
}
