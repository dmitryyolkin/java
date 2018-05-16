package web.spittr.web;

import web.spittr.web.dto.Spittle;

import java.util.List;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (15.05.18)
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}