package com.yolkin.springdemo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *  Увидев в зависимостях H2 (встраиваемая БД), Boot автоматически конфигурит DataSource
 *  (это ключевой компонент для подключения к базе), чтобы приложение работало с этой базой
 *
 *  Spring Data ищет всех наследников CrudRepository и автоматически генерит для них дефолтные
 *  реализации, которые включают базовые методы репозитория, типа findOne, findAll, save etc.
 *
 *  Spring автоматически конфигурит слой для доступа к данным — JPA (точнее, его реализацию Hibernate)
 *
 *  Благодаря аннотации @Repository этот компонент становится доступным в нашем приложении
 *  (и мы его используем через пару минут)
 *
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (22.03.18)
 */
@Repository
public interface VisitsRepository extends CrudRepository<Visit, Long> {
}
