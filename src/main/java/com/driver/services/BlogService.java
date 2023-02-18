package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createBlog(Integer userId, String title, String content) {
        //create a blog at the current time
        Blog blog = new Blog(title, content);
        User user = userRepository1.findById(userId).get();
        if(user!=null){
            blog.setUser(user);
            List<Blog> blogsWritten = user.getBlogList();
            blogsWritten.add(blog);
            user.setBlogList(blogsWritten);
            userRepository1.save(user);
        }
        return blog;
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        Blog blog = blogRepository1.findById(blogId).get();
        if(blog!=null){
            blogRepository1.deleteById(blogId);
        }
    }
}
