package project.nft.nft.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.nft.nft.models.RecentCollection;
import project.nft.nft.services.RecentCollectionService;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:4200"}, maxAge = 6000)
@RequestMapping("/recent-collections")
@RequiredArgsConstructor
public class RecentCollectionController {
    @Autowired
    private final RecentCollectionService recentCollectionService;

    @GetMapping("/list")
    public List<RecentCollection> getCollections() {
        System.out.println(this.recentCollectionService.list().get(0));
        return this.recentCollectionService.list();
    }

}
