package ru.bogatov.VueApp.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.bogatov.VueApp.Dao.PictureSetRepo;
import ru.bogatov.VueApp.Dao.PicturesEntryRepo;
import ru.bogatov.VueApp.Entities.PicturesEntry;
import ru.bogatov.VueApp.Entities.PicturesSet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class PictureService {
    @Value("${upload.path}")
    private String path;

    private PictureSetRepo pictureSetRepo;
    private PicturesEntryRepo picturesEntryRepo;

    public PictureService(PictureSetRepo pictureSetRepo, PicturesEntryRepo picturesEntryRepo) {
        this.pictureSetRepo = pictureSetRepo;
        this.picturesEntryRepo = picturesEntryRepo;
    }

    public PicturesSet saveFiles(MultipartFile[] file) throws IOException {
        File dir = new File(path);
        PicturesSet picturesSet = new PicturesSet();
        picturesSet.pictures = new ArrayList<>();
        if(!dir.exists()){
            dir.mkdir();
        }
            for (MultipartFile multipartFile : file) {
                PicturesEntry p = new PicturesEntry();
                String fileName = UUID.randomUUID().toString() + "." + multipartFile.getOriginalFilename();
                p.setSource("http://localhost:8082/static/images/" + fileName);
                multipartFile.transferTo(new File(path + '/' + fileName));
                p = picturesEntryRepo.save(p);
                picturesSet.pictures.add(p);
            }
        picturesSet = pictureSetRepo.save(picturesSet);
        return picturesSet;
    }
}
