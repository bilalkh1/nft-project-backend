package project.nft.nft.services;

import java.util.Collection;
import java.util.List;

public interface CollectionService {
    Collection<project.nft.nft.models.Collection> list(int limit, int page);
    List<project.nft.nft.models.Collection> getCollectionData();
    List<project.nft.nft.models.Collection> returnCollectionFromCSV(String fileName, String fileNameKmeans);
}
