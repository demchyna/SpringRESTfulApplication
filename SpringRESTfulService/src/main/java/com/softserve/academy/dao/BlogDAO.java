package com.softserve.academy.dao;

import com.softserve.academy.models.Blog;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BlogDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addPost(Blog blog) {
        sessionFactory.getCurrentSession().save(blog);
    }

    @Transactional
    public Blog getPostById(int id) {
        Blog blog = sessionFactory.getCurrentSession().get(Blog.class, id);
        if (blog != null) {
            return blog;
        }
        return null;
    }

    @Transactional
    public void updatePost(Blog blog) {
        sessionFactory.getCurrentSession().update(blog);
    }

    @Transactional
    public void deletePost(int id) {
        Blog blog = sessionFactory.getCurrentSession().get(Blog.class, id);
        if (blog != null) {
            sessionFactory.getCurrentSession().delete(blog);
        }
    }

    @Transactional
    public List<Blog> getAllPosts() {
        @SuppressWarnings("unchecked")
        List<Blog> posts = sessionFactory.getCurrentSession().createQuery("FROM Blog").list();
        if (!posts.isEmpty()) {
            return posts;
        }
        return null;
    }

    @Transactional
    public List<Blog> getPostsByUserId(int id) {

        String hql = "FROM Blog B WHERE B.user.id = :userId";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        query.setParameter("userId", id);

        @SuppressWarnings("unchecked")
        List<Blog> posts = query.list();
        if (!posts.isEmpty()) {
            return posts;
        }
        return null;
    }
}
