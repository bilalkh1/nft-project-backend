package project.nft.nft.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.nft.nft.models.TopCollections;
import project.nft.nft.repositories.TopCollectionRepository;
import project.nft.nft.services.TopCollectionService;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class TopCollectionServiceImpl implements TopCollectionService {

    @Autowired
    private final TopCollectionRepository topCollectionRepository;

    @Override
    public List<TopCollections> list() {
        return this.topCollectionRepository.findAll();
    }
}
