package com.gcu.preach.Business;


import com.gcu.preach.model.BlogPost;
import com.gcu.preach.model.BlogPostsList;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BlogPostsBusinessService implements BlogPostsBusinessInterface {


    @Override
    public List<BlogPost> getAllBlogPosts() {

        List<BlogPost> blogPosts = new ArrayList<>();
        blogPosts.add(new BlogPost(1, "Exhortation to Walk as Christians", "When God was about to lead the Israelites" +
                " out of Egypt, he commanded, shortly before their departure, that they should eat the Passover the " +
                "night they started; and as a perpetual memorial of their redemption, they were annually, on the " +
                "recurrence of the season, to celebrate the feast of Easter for seven days. A specially urgent feature " +
                "of the command was that on the first evening of the feast they must put out of their houses all " +
                "leaven and leavened bread, and during the seven days eat none but the unleavened bread, or cakes. " +
                "Hence the evangelists speak of the feast as the Feast (or Days) of Unleavened Bread. ",
                "Dr. Maritain Luther King", "1540 A.D"));
        blogPosts.add(new BlogPost(2, "SALVATION ALL OF GRACE", "OTHER Divine attributes are manifest" +
                " in salvation. The wisdom of God devised the plan; the power of God executes in us the work of" +
                " salvation; the immutability of God preserves and carries it on ", "C. H. SPURGEON",
                "08/04/1872"));
        blogPosts.add(new BlogPost(3, "SALVATION ALTOGETHER BY GRACE", "IF we would influence" +
                " thoughtful persons it must be by solid arguments. Shallow minds may be wrought upon by mere" +
                " warmth of emotion and force of excitement, but the more valuable part of the community must" +
                " be dealt with in quite another manner. ", "C. H. SPURGEON",
                "07/29/1866"));
        blogPosts.add(new BlogPost(4, "Instantaneous Salvation", "I propose tonight to take" +
                " a subject rather than a text, and that subject is conversion -- instant salvation. One reason why" +
                " I am led to take up this subject is because I have received a large number of letters asking me how" +
                " it is that I can teach such a \"pernicious doctrine\" that a man can be saved all at once -- that" +
                " salvation is instantaneous. ", "D. L. Moody",
                "Unknown"));
        blogPosts.add(new BlogPost(5, "Heaven - Its Hope", "A great many persons; imagine that " +
                "anything said about heaven is only a matter of speculation. They talk about heaven like the air." +
                " Now there would not have been so much in Scripture on this subject if God had wanted to leave the" +
                " human race in darkness about it, All Scripture, we are told, is given by inspiration of God, and is" +
                " profitable for doctrine, for reproof, for correction, for instruction in righteousness, that the man" +
                " of God may be perfect - thoroughly furnished unto all good works. ", "D. L. Moody",
                "Unknown"));
        return blogPosts;
    }


}
