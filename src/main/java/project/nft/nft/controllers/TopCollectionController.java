package project.nft.nft.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.nft.nft.models.RecentCollection;
import project.nft.nft.models.TopCollections;
import project.nft.nft.services.TopCollectionService;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:4200"}, maxAge = 6000)
@RequestMapping("/top-collections")
@RequiredArgsConstructor
public class TopCollectionController {

    @Autowired
    private final TopCollectionService topCollectionService;

    @GetMapping("/list")
    public List<TopCollections> getCollections() {
        System.out.println(this.topCollectionService.list().get(0));
        return this.topCollectionService.list();
    }

}
