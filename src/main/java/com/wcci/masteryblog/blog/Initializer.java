package com.wcci.masteryblog.blog;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.wcci.masteryblog.blog.models.Author;
import com.wcci.masteryblog.blog.models.Genre;
import com.wcci.masteryblog.blog.models.Octothorp;
import com.wcci.masteryblog.blog.models.Post;
import com.wcci.masteryblog.blog.repositories.AuthorsRepository;
import com.wcci.masteryblog.blog.repositories.GenreRepository;
import com.wcci.masteryblog.blog.repositories.OctoRepository;
import com.wcci.masteryblog.blog.repositories.PostsRepository;

@Service
public class Initializer implements CommandLineRunner {

	@Resource
	PostsRepository postsRepo;
	@Resource
	AuthorsRepository authorsRepo;
	@Resource
	GenreRepository genreRepo;
	@Resource
	OctoRepository octoRepo;

	@Override
	public void run(String... args) throws Exception {

		// AUTHOR INITIALIZER//
		Author chad = authorsRepo.save(new Author("Chad", "Collins"));
		Author nick = authorsRepo.save(new Author("Nick", "Miner"));

		// GENRE INITIALIZER//
		Genre howTo = genreRepo.save(new Genre("HOW TO"));
		Genre review = genreRepo.save(new Genre("REVIEW"));
		Genre news = genreRepo.save(new Genre("NEWS"));
		Genre daily = genreRepo.save(new Genre("DAILY BLOG"));
		
		
		// OCTOTHORP INITIALIZER//
			Octothorp tech = octoRepo.save(new Octothorp("Tech"));
			Octothorp funny = octoRepo.save(new Octothorp("Funny"));
			Octothorp rant = octoRepo.save(new Octothorp("Rant"));
			Octothorp mobile = octoRepo.save(new Octothorp("Mobile"));
			Octothorp movie = octoRepo.save(new Octothorp("Movie"));
					

		

		// POST INITIALIZER//
		Post chadHowToMobile = postsRepo.save(new Post("How To Write A Blog Post", chad, howTo, 
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec venenatis nibh. Phasellus porta iaculis metus. Suspendisse potenti. Etiam suscipit aliquam mauris, a aliquet erat lobortis vitae. Sed consectetur, nisi quis iaculis luctus, nisi nibh ornare augue, et dapibus arcu massa at orci. Nullam a eros sit amet lacus luctus laoreet. Nam id ipsum est. Maecenas aliquam viverra tortor. Ut a turpis eu enim lacinia mattis ut sed mi. In quis scelerisque felis. Pellentesque tincidunt neque tincidunt, porttitor risus viverra, convallis tellus. Nullam fermentum et massa dignissim mattis. Praesent a nulla lectus.\n"
						+ "\n"
						+ "Nulla lobortis at nunc id aliquam. Quisque ut tempor turpis. Etiam malesuada orci venenatis ligula sodales, id vehicula erat efficitur. Praesent elementum a eros non consequat. Nunc volutpat faucibus nibh et congue. Aenean tristique sapien nisi, nec suscipit risus pharetra egestas. Integer commodo sit amet est vitae dignissim. Morbi ligula orci, sodales at ornare sit amet, porttitor quis enim. Quisque eros metus, iaculis vitae sagittis vel, laoreet non justo. Suspendisse et venenatis dui. Morbi euismod, elit et accumsan luctus, dui arcu efficitur nisi, sed ornare eros quam sed arcu. Vivamus nibh nisl, malesuada vel aliquam a, ultrices venenatis lorem. Nulla lobortis felis ac turpis finibus commodo. Vivamus elementum sapien a mauris pulvinar aliquet.\n"
						+ "\n"
						+ "Nullam a efficitur lectus, faucibus rutrum lorem. Aliquam facilisis tempus libero id placerat. In mollis, eros nec mattis accumsan, lectus nulla vestibulum quam, sed dictum odio purus in erat. Nunc at velit consectetur, suscipit purus eu, condimentum elit. Etiam vehicula ex quis neque tincidunt blandit. Fusce quis vestibulum erat. Suspendisse molestie porttitor lectus eget volutpat. Mauris ultrices vestibulum odio, eu iaculis est pellentesque in.\n"
						+ "\n"
						+ "Curabitur nec convallis metus. Sed bibendum, mi nec scelerisque tincidunt, nisl massa aliquam tellus, sit amet euismod nunc purus eu purus. Vivamus venenatis porta aliquet. Integer scelerisque a tellus eget faucibus. Nulla facilisi. Aenean tristique faucibus eros eu mollis. Sed lacinia faucibus urna, hendrerit feugiat nunc euismod ac. Maecenas maximus lorem at felis aliquam ullamcorper. Mauris commodo placerat est, id porttitor dui feugiat laoreet. In ac placerat metus.\n"
						+ "\n"
						+ "Mauris dapibus eu quam in ornare. Vestibulum ac justo eget turpis cursus ullamcorper. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vivamus interdum sapien eget dolor consequat tristique. Integer eu dolor ut erat lacinia pulvinar. Suspendisse potenti. Nunc mollis, enim id porttitor ultrices, massa nunc commodo nunc, vel faucibus tellus tortor vel metus. Praesent libero sapien, feugiat facilisis eleifend eget, venenatis nec felis. Vestibulum vehicula ex a bibendum efficitur. Vivamus eget auctor mauris. Quisque porttitor feugiat facilisis. Phasellus ut sagittis eros, nec consectetur mauris. Curabitur finibus, quam vitae convallis semper, ante massa dignissim augue, nec placerat lectus odio tempus justo. Etiam a ex nulla.\n"
						+ "\n"
						+ "In vel felis sagittis, malesuada dolor non, dignissim mi. Nulla facilisi. Nullam porta, quam eu accumsan fermentum, massa enim eleifend nunc, ut porta eros lacus id dui. Donec nec leo nec ex aliquet condimentum. Donec euismod purus quis dui euismod vestibulum. Integer vulputate arcu et nisi sodales fringilla at eget urna. Aliquam volutpat augue sapien, et tempus eros pretium eget. Maecenas volutpat, orci quis molestie pulvinar, tellus est elementum leo, vitae condimentum augue ex et nisi.\n"
						+ "\n"
						+ "Sed id tincidunt quam, quis venenatis ipsum. Aliquam gravida risus ante, eleifend rhoncus velit mattis quis. Nullam felis orci, vulputate sed sodales sed, accumsan vel ligula. Duis aliquam bibendum orci, auctor finibus neque eleifend at. Morbi viverra rutrum iaculis. Etiam at tortor in neque egestas posuere. Cras id leo augue.", mobile, tech));

		Post nickReviewMovie = postsRepo.save(new Post("Review: Spider-Man: Into the Spider-Verse", nick, review,
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec venenatis nibh. Phasellus porta iaculis metus. Suspendisse potenti. Etiam suscipit aliquam mauris, a aliquet erat lobortis vitae. Sed consectetur, nisi quis iaculis luctus, nisi nibh ornare augue, et dapibus arcu massa at orci. Nullam a eros sit amet lacus luctus laoreet. Nam id ipsum est. Maecenas aliquam viverra tortor. Ut a turpis eu enim lacinia mattis ut sed mi. In quis scelerisque felis. Pellentesque tincidunt neque tincidunt, porttitor risus viverra, convallis tellus. Nullam fermentum et massa dignissim mattis. Praesent a nulla lectus.\n"
						+ "\n"
						+ "Nulla lobortis at nunc id aliquam. Quisque ut tempor turpis. Etiam malesuada orci venenatis ligula sodales, id vehicula erat efficitur. Praesent elementum a eros non consequat. Nunc volutpat faucibus nibh et congue. Aenean tristique sapien nisi, nec suscipit risus pharetra egestas. Integer commodo sit amet est vitae dignissim. Morbi ligula orci, sodales at ornare sit amet, porttitor quis enim. Quisque eros metus, iaculis vitae sagittis vel, laoreet non justo. Suspendisse et venenatis dui. Morbi euismod, elit et accumsan luctus, dui arcu efficitur nisi, sed ornare eros quam sed arcu. Vivamus nibh nisl, malesuada vel aliquam a, ultrices venenatis lorem. Nulla lobortis felis ac turpis finibus commodo. Vivamus elementum sapien a mauris pulvinar aliquet.\n"
						+ "\n"
						+ "Nullam a efficitur lectus, faucibus rutrum lorem. Aliquam facilisis tempus libero id placerat. In mollis, eros nec mattis accumsan, lectus nulla vestibulum quam, sed dictum odio purus in erat. Nunc at velit consectetur, suscipit purus eu, condimentum elit. Etiam vehicula ex quis neque tincidunt blandit. Fusce quis vestibulum erat. Suspendisse molestie porttitor lectus eget volutpat. Mauris ultrices vestibulum odio, eu iaculis est pellentesque in.\n"
						+ "\n"
						+ "Curabitur nec convallis metus. Sed bibendum, mi nec scelerisque tincidunt, nisl massa aliquam tellus, sit amet euismod nunc purus eu purus. Vivamus venenatis porta aliquet. Integer scelerisque a tellus eget faucibus. Nulla facilisi. Aenean tristique faucibus eros eu mollis. Sed lacinia faucibus urna, hendrerit feugiat nunc euismod ac. Maecenas maximus lorem at felis aliquam ullamcorper. Mauris commodo placerat est, id porttitor dui feugiat laoreet. In ac placerat metus.\n"
						+ "\n"
						+ "Mauris dapibus eu quam in ornare. Vestibulum ac justo eget turpis cursus ullamcorper. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vivamus interdum sapien eget dolor consequat tristique. Integer eu dolor ut erat lacinia pulvinar. Suspendisse potenti. Nunc mollis, enim id porttitor ultrices, massa nunc commodo nunc, vel faucibus tellus tortor vel metus. Praesent libero sapien, feugiat facilisis eleifend eget, venenatis nec felis. Vestibulum vehicula ex a bibendum efficitur. Vivamus eget auctor mauris. Quisque porttitor feugiat facilisis. Phasellus ut sagittis eros, nec consectetur mauris. Curabitur finibus, quam vitae convallis semper, ante massa dignissim augue, nec placerat lectus odio tempus justo. Etiam a ex nulla.\n"
						+ "\n"
						+ "In vel felis sagittis, malesuada dolor non, dignissim mi. Nulla facilisi. Nullam porta, quam eu accumsan fermentum, massa enim eleifend nunc, ut porta eros lacus id dui. Donec nec leo nec ex aliquet condimentum. Donec euismod purus quis dui euismod vestibulum. Integer vulputate arcu et nisi sodales fringilla at eget urna. Aliquam volutpat augue sapien, et tempus eros pretium eget. Maecenas volutpat, orci quis molestie pulvinar, tellus est elementum leo, vitae condimentum augue ex et nisi.\n"
						+ "\n"
						+ "Sed id tincidunt quam, quis venenatis ipsum. Aliquam gravida risus ante, eleifend rhoncus velit mattis quis. Nullam felis orci, vulputate sed sodales sed, accumsan vel ligula. Duis aliquam bibendum orci, auctor finibus neque eleifend at. Morbi viverra rutrum iaculis. Etiam at tortor in neque egestas posuere. Cras id leo augue.", movie));

		Post nickNewsRant = postsRepo.save(new Post("My Thoughts on this Lorem Ipsum Policy.", nick, news,
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec venenatis nibh. Phasellus porta iaculis metus. Suspendisse potenti. Etiam suscipit aliquam mauris, a aliquet erat lobortis vitae. Sed consectetur, nisi quis iaculis luctus, nisi nibh ornare augue, et dapibus arcu massa at orci. Nullam a eros sit amet lacus luctus laoreet. Nam id ipsum est. Maecenas aliquam viverra tortor. Ut a turpis eu enim lacinia mattis ut sed mi. In quis scelerisque felis. Pellentesque tincidunt neque tincidunt, porttitor risus viverra, convallis tellus. Nullam fermentum et massa dignissim mattis. Praesent a nulla lectus.\n"
						+ "\n"
						+ "Nulla lobortis at nunc id aliquam. Quisque ut tempor turpis. Etiam malesuada orci venenatis ligula sodales, id vehicula erat efficitur. Praesent elementum a eros non consequat. Nunc volutpat faucibus nibh et congue. Aenean tristique sapien nisi, nec suscipit risus pharetra egestas. Integer commodo sit amet est vitae dignissim. Morbi ligula orci, sodales at ornare sit amet, porttitor quis enim. Quisque eros metus, iaculis vitae sagittis vel, laoreet non justo. Suspendisse et venenatis dui. Morbi euismod, elit et accumsan luctus, dui arcu efficitur nisi, sed ornare eros quam sed arcu. Vivamus nibh nisl, malesuada vel aliquam a, ultrices venenatis lorem. Nulla lobortis felis ac turpis finibus commodo. Vivamus elementum sapien a mauris pulvinar aliquet.\n"
						+ "\n"
						+ "Nullam a efficitur lectus, faucibus rutrum lorem. Aliquam facilisis tempus libero id placerat. In mollis, eros nec mattis accumsan, lectus nulla vestibulum quam, sed dictum odio purus in erat. Nunc at velit consectetur, suscipit purus eu, condimentum elit. Etiam vehicula ex quis neque tincidunt blandit. Fusce quis vestibulum erat. Suspendisse molestie porttitor lectus eget volutpat. Mauris ultrices vestibulum odio, eu iaculis est pellentesque in.\n"
						+ "\n"
						+ "Curabitur nec convallis metus. Sed bibendum, mi nec scelerisque tincidunt, nisl massa aliquam tellus, sit amet euismod nunc purus eu purus. Vivamus venenatis porta aliquet. Integer scelerisque a tellus eget faucibus. Nulla facilisi. Aenean tristique faucibus eros eu mollis. Sed lacinia faucibus urna, hendrerit feugiat nunc euismod ac. Maecenas maximus lorem at felis aliquam ullamcorper. Mauris commodo placerat est, id porttitor dui feugiat laoreet. In ac placerat metus.\n"
						+ "\n"
						+ "Mauris dapibus eu quam in ornare. Vestibulum ac justo eget turpis cursus ullamcorper. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vivamus interdum sapien eget dolor consequat tristique. Integer eu dolor ut erat lacinia pulvinar. Suspendisse potenti. Nunc mollis, enim id porttitor ultrices, massa nunc commodo nunc, vel faucibus tellus tortor vel metus. Praesent libero sapien, feugiat facilisis eleifend eget, venenatis nec felis. Vestibulum vehicula ex a bibendum efficitur. Vivamus eget auctor mauris. Quisque porttitor feugiat facilisis. Phasellus ut sagittis eros, nec consectetur mauris. Curabitur finibus, quam vitae convallis semper, ante massa dignissim augue, nec placerat lectus odio tempus justo. Etiam a ex nulla.\n"
						+ "\n"
						+ "In vel felis sagittis, malesuada dolor non, dignissim mi. Nulla facilisi. Nullam porta, quam eu accumsan fermentum, massa enim eleifend nunc, ut porta eros lacus id dui. Donec nec leo nec ex aliquet condimentum. Donec euismod purus quis dui euismod vestibulum. Integer vulputate arcu et nisi sodales fringilla at eget urna. Aliquam volutpat augue sapien, et tempus eros pretium eget. Maecenas volutpat, orci quis molestie pulvinar, tellus est elementum leo, vitae condimentum augue ex et nisi.\n"
						+ "\n"
						+ "Sed id tincidunt quam, quis venenatis ipsum. Aliquam gravida risus ante, eleifend rhoncus velit mattis quis. Nullam felis orci, vulputate sed sodales sed, accumsan vel ligula. Duis aliquam bibendum orci, auctor finibus neque eleifend at. Morbi viverra rutrum iaculis. Etiam at tortor in neque egestas posuere. Cras id leo augue.", rant));

		Post chadDailyFunny = postsRepo.save(new Post("A Day in the Life of a Developer.", chad, daily,
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec venenatis nibh. Phasellus porta iaculis metus. Suspendisse potenti. Etiam suscipit aliquam mauris, a aliquet erat lobortis vitae. Sed consectetur, nisi quis iaculis luctus, nisi nibh ornare augue, et dapibus arcu massa at orci. Nullam a eros sit amet lacus luctus laoreet. Nam id ipsum est. Maecenas aliquam viverra tortor. Ut a turpis eu enim lacinia mattis ut sed mi. In quis scelerisque felis. Pellentesque tincidunt neque tincidunt, porttitor risus viverra, convallis tellus. Nullam fermentum et massa dignissim mattis. Praesent a nulla lectus.\n"
						+ "\n"
						+ "Nulla lobortis at nunc id aliquam. Quisque ut tempor turpis. Etiam malesuada orci venenatis ligula sodales, id vehicula erat efficitur. Praesent elementum a eros non consequat. Nunc volutpat faucibus nibh et congue. Aenean tristique sapien nisi, nec suscipit risus pharetra egestas. Integer commodo sit amet est vitae dignissim. Morbi ligula orci, sodales at ornare sit amet, porttitor quis enim. Quisque eros metus, iaculis vitae sagittis vel, laoreet non justo. Suspendisse et venenatis dui. Morbi euismod, elit et accumsan luctus, dui arcu efficitur nisi, sed ornare eros quam sed arcu. Vivamus nibh nisl, malesuada vel aliquam a, ultrices venenatis lorem. Nulla lobortis felis ac turpis finibus commodo. Vivamus elementum sapien a mauris pulvinar aliquet.\n"
						+ "\n"
						+ "Nullam a efficitur lectus, faucibus rutrum lorem. Aliquam facilisis tempus libero id placerat. In mollis, eros nec mattis accumsan, lectus nulla vestibulum quam, sed dictum odio purus in erat. Nunc at velit consectetur, suscipit purus eu, condimentum elit. Etiam vehicula ex quis neque tincidunt blandit. Fusce quis vestibulum erat. Suspendisse molestie porttitor lectus eget volutpat. Mauris ultrices vestibulum odio, eu iaculis est pellentesque in.\n"
						+ "\n"
						+ "Curabitur nec convallis metus. Sed bibendum, mi nec scelerisque tincidunt, nisl massa aliquam tellus, sit amet euismod nunc purus eu purus. Vivamus venenatis porta aliquet. Integer scelerisque a tellus eget faucibus. Nulla facilisi. Aenean tristique faucibus eros eu mollis. Sed lacinia faucibus urna, hendrerit feugiat nunc euismod ac. Maecenas maximus lorem at felis aliquam ullamcorper. Mauris commodo placerat est, id porttitor dui feugiat laoreet. In ac placerat metus.\n"
						+ "\n"
						+ "Mauris dapibus eu quam in ornare. Vestibulum ac justo eget turpis cursus ullamcorper. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vivamus interdum sapien eget dolor consequat tristique. Integer eu dolor ut erat lacinia pulvinar. Suspendisse potenti. Nunc mollis, enim id porttitor ultrices, massa nunc commodo nunc, vel faucibus tellus tortor vel metus. Praesent libero sapien, feugiat facilisis eleifend eget, venenatis nec felis. Vestibulum vehicula ex a bibendum efficitur. Vivamus eget auctor mauris. Quisque porttitor feugiat facilisis. Phasellus ut sagittis eros, nec consectetur mauris. Curabitur finibus, quam vitae convallis semper, ante massa dignissim augue, nec placerat lectus odio tempus justo. Etiam a ex nulla.\n"
						+ "\n"
						+ "In vel felis sagittis, malesuada dolor non, dignissim mi. Nulla facilisi. Nullam porta, quam eu accumsan fermentum, massa enim eleifend nunc, ut porta eros lacus id dui. Donec nec leo nec ex aliquet condimentum. Donec euismod purus quis dui euismod vestibulum. Integer vulputate arcu et nisi sodales fringilla at eget urna. Aliquam volutpat augue sapien, et tempus eros pretium eget. Maecenas volutpat, orci quis molestie pulvinar, tellus est elementum leo, vitae condimentum augue ex et nisi.\n"
						+ "\n"
						+ "Sed id tincidunt quam, quis venenatis ipsum. Aliquam gravida risus ante, eleifend rhoncus velit mattis quis. Nullam felis orci, vulputate sed sodales sed, accumsan vel ligula. Duis aliquam bibendum orci, auctor finibus neque eleifend at. Morbi viverra rutrum iaculis. Etiam at tortor in neque egestas posuere. Cras id leo augue.", funny));
		
	}			
}
