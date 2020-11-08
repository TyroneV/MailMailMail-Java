package com.m3.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.m3.model.Post;
import com.m3.model.PostBuilt;
import com.m3.service.PostService;

@Controller
@CrossOrigin
@RequestMapping/*("/post.app")*/
public class PostController {
//	@Autowired
	private PostService ps;

	public PostService getPs() {
		return ps;
	}

	@Autowired
	public void setPs(PostService ps) {
		this.ps = ps;
	}

	@GetMapping("/postAll.app")
	public @ResponseBody List<PostBuilt> getAll() {
		List<Post> posts = ps.getAllPosts();
		List<PostBuilt> builtPosts = new LinkedList<>();
		for(Post p : posts) {
			builtPosts.add(new PostBuilt(p));
		}
		
		
		return builtPosts;
	}

	@GetMapping("/postAUser.app")
	public @ResponseBody List<PostBuilt> getAllPostsByUser(@RequestParam Integer id) {
		List<Post> posts = ps.getAllPostsByUser(id);
		List<PostBuilt> builtPosts = new LinkedList<>();
		for(Post p : posts) {
			builtPosts.add(new PostBuilt(p));
		}
		
		return builtPosts;
	}
	
//	@GetMapping
//	public @ResponseBody List<String> getAll() {
//		return ps.getAllPostsString();
//
//	}

}
