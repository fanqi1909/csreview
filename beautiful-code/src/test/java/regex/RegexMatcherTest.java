package regex;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegexMatcherTest {

    @Test
    public void match() {
        RegexMatcher matcher = new RegexMatcher("this", "this is a book");
        Assert.assertTrue(matcher.match());

        matcher = new RegexMatcher("is", "this is a book");
        Assert.assertTrue(matcher.match());

        matcher = new RegexMatcher("isnot", "this is a book");
        Assert.assertFalse(matcher.match());

        matcher = new RegexMatcher("^this", "this is a book");
        Assert.assertTrue(matcher.match());

        matcher = new RegexMatcher("^is", "this is a book");
        Assert.assertFalse(matcher.match());

        matcher = new RegexMatcher("book$", "this is a book");
        Assert.assertTrue(matcher.match());

        matcher = new RegexMatcher("this$", "this is a book");
        Assert.assertFalse(matcher.match());

        matcher = new RegexMatcher("is.a.book", "this is a book");
        Assert.assertTrue(matcher.match());

        matcher = new RegexMatcher("is.*.book", "this is a book");
        Assert.assertTrue(matcher.match());

        matcher = new RegexMatcher("^is.*k$", "this is a book");
        Assert.assertFalse(matcher.match());

        matcher = new RegexMatcher("^this.*a .*k$", "this is a book");
        Assert.assertTrue(matcher.match());


        matcher = new RegexMatcher("^th+is", "this");
        Assert.assertTrue(matcher.match());

        matcher = new RegexMatcher("^th+is", "thhhis");
        Assert.assertTrue(matcher.match());

        matcher = new RegexMatcher("^th+is", "tis");
        Assert.assertFalse(matcher.match());

        matcher = new RegexMatcher("^th*is", "tis");
        Assert.assertTrue(matcher.match());

        matcher = new RegexMatcher("thi?s", "thisssss");
        Assert.assertTrue(matcher.match());

        matcher = new RegexMatcher("thi?s", "thsss");
        Assert.assertTrue(matcher.match());

        matcher = new RegexMatcher("thi?s", "thiisss");
        Assert.assertFalse(matcher.match());

    }
}