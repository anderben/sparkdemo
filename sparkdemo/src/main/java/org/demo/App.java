package org.demo;

import static spark.Spark.get;

import org.apache.commons.lang3.StringUtils;
import org.demo.model.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.Request;
import spark.Response;
import spark.Route;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;

/**
 * Hello world!
 */
public class App {

	static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {

		get(new Route("/test") {
			@Override
			public Object handle(Request request, Response response) {
				String sql = "select current_timestamp() as ctime";
				SqlRow row = Ebean.createSqlQuery(sql).findUnique();
				String time = row.getString("ctime");
				return time;
			}
		});

		get(new Route("/insert/:comment") {
			@Override
			public Object handle(Request request, Response response) {
				String commentText = StringUtils.trimToNull(request
						.params(":comment"));
				if (commentText != null) {
					Comment comment = new Comment(commentText);
					Ebean.save(comment);
				}
				return String.format("Comment was %s", commentText);
			}
		});

	}

}
