package com.example.demo.templates;

import com.example.demo.domain.Member;
import com.example.demo.domain.Members;
import com.rometools.rome.feed.atom.Content;
import com.rometools.rome.feed.atom.Entry;
import com.rometools.rome.feed.atom.Feed;
import org.springframework.web.servlet.view.feed.AbstractAtomFeedView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AtomFeedView extends AbstractAtomFeedView {

    @Override
    protected void buildFeedMetadata(Map<String, Object> model, Feed feed, HttpServletRequest request) {
        feed.setId("football.org");
        feed.setTitle("Football");
        feed.setLogo("Football LOGO");
        feed.setUpdated(new Date());
    }

    @Override
    protected List<Entry> buildFeedEntries(Map<String, Object> map, HttpServletRequest httpServletRequest,
                                           HttpServletResponse httpServletResponse) {
        Members members = (Members) map.get("members");
        return members.getMembers()
                .stream()
                .map(this::buildMemberEntry)
                .collect(Collectors.toList());
    }

    private Entry buildMemberEntry(Member member) {
        Entry entry = new Entry();
        entry.setId(member.getName());
        entry.setTitle(member.getAge().toString());
        entry.setUpdated(new Date());

        Content content = new Content();
        content.setValue(member.getName() + " - " + member.getAge().toString());
        entry.setSummary(content);
        return entry;
    }
}
