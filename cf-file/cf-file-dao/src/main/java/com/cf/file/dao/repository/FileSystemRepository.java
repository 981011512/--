package com.cf.file.dao.repository;

import com.cf.file.domain.FileSystem;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Administrator.
 */
public interface FileSystemRepository extends MongoRepository<FileSystem,String> {
}
