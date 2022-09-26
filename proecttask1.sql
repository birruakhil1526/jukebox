create database jukebox;
use jukebox;
create table songs(
song_Id int primary key,
song_Name varchar(30) unique not null,
artist_Name varchar(30) not null,
album_Name varchar(30) not null,
genre varchar(30) not null,
song_Duration float not null);
drop table songs;