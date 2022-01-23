package project.nft.nft.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.nft.nft.models.Collection;
import project.nft.nft.services.CollectionService;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:4200"}, maxAge = 6000)
@RequestMapping("/collections")
@RequiredArgsConstructor
public class CollectionController {
    @Autowired
    private final CollectionService collectionService;

    @GetMapping("/list")
    public List<Collection> getCollections(@RequestParam("limit") int limit, @RequestParam("page") int page) {
        System.out.println(limit);
        System.out.println(page);
        return (List<Collection>) this.collectionService.list(limit, page);
    }

}
