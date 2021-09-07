package com.example.demo.templates;

import com.example.demo.domain.Member;
import com.example.demo.domain.Members;
import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Item;
import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RssFeedView extends AbstractRssFeedView {

    @Override
    protected void buildFeedMetadata(Map<String, Object> model, Channel feed, HttpServletRequest request) {
        feed.setLink("football.org");
        feed.setTitle("Football");
        feed.setDescription("Football Description");
        feed.setLastBuildDate(new Date());
    }

    @Override
    protected List<Item> buildFeedItems(Map<String, Object> map, HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse) {
        Members members = (Members) map.get("members");
        return members.getMembers()
                .stream()
                .map(this::buildMemberEntry)
                .collect(Collectors.toList());
    }

    private Item buildMemberEntry(Member member) {
        Item item = new Item();
        item.setAuthor(member.getName());
        item.setTitle(member.getName() + " - " + member.getAge().toString());
        item.setPubDate(new Date());
        item.setLink("weallovefutboall.org");
        return item;
    }
}
