package com.example.mova.ui.features.movieDetails.dummydata

import com.example.mova.R
import com.example.mova.data.network.model.ExploreMovieItem

val movieDetail: ExploreMovieItem = ExploreMovieItem(
    bigImage = "https://m.media-amazon.com/images/M/MV5BZGMxZTdjZmYtMmE2Ni00ZTdkLWI5NTgtNjlmMjBiNzU2MmI5XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_QL75_UX380_CR0,14,380,562_.jpg",
    description = "While Frodo and Sam edge closer to Mordor with the help of the shifty Gollum, the divided fellowship makes a stand against Sauron's new ally, Saruman, and his hordes of Isengard.",
    genre = listOf("Action", "Adventure", "Drama"),
    id = "top13",
    image = "https://m.media-amazon.com/images/M/MV5BZGMxZTdjZmYtMmE2Ni00ZTdkLWI5NTgtNjlmMjBiNzU2MmI5XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_QL75_UX380_CR0,14,380,562_.jpg",
    imdbLink = "https://www.imdb.com/title/tt0167261",
    imdbid = "tt0167261",
    rank = 13,
    rating = "8.8",
    thumbnail = "https://m.media-amazon.com/images/M/MV5BZGMxZTdjZmYtMmE2Ni00ZTdkLWI5NTgtNjlmMjBiNzU2MmI5XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_UX45_CR0,0,45,67_AL_.jpg",
    title = "The Lord of the Rings: The Two Towers",
    year = 2002
)

val stars: List<StarsModel> = listOf(
    StarsModel(
        name = "Peter Jackson",
        image = R.drawable.peter_jackson,
        type = Types.Director
    ),
    StarsModel(
        name = "Elijah Wood",
        image = R.drawable.elijah_wood,
        type = Types.Actor
    ),
    StarsModel(
        name = "Ian Mckellen",
        image = R.drawable.ian_mckellen,
        type = Types.Actor
    ),
    StarsModel(
        name = "Orlando Bloom",
        image = R.drawable.orlando_bloom,
        type = Types.Actor
    )
)

val moreLikeThis: List<ExploreMovieItem> = listOf(
    ExploreMovieItem(
        bigImage = "https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDItYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_QL75_UX380_CR0,0,380,562_.jpg",
        description = "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.",
        genre = listOf("Action", "Adventure", "Drama"),
        id = "top7",
        image = "https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDItYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_QL75_UX380_CR0,0,380,562_.jpg",
        imdbLink = "https://www.imdb.com/title/tt0167260",
        imdbid = "tt0167260",
        rank = 7,
        rating = "9.0",
        thumbnail = "https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDItYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UY67_CR0,0,45,67_AL_.jpg",
        title = "The Lord of the Rings: The Return of the King",
        year = 2003
    ),
    ExploreMovieItem(
        bigImage = "https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@",
        description = "A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.",
        genre = listOf("Action", "Adventure", "Drama"),
        id = "top9",
        image = "https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_QL75_UX380_CR0,1,380,562_.jpg",
        imdbLink = "https://www.imdb.com/title/tt0120737",
        imdbid = "tt0120737",
        rank = 9,
        rating = "8.8",
        thumbnail = "https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_UY67_CR0,0,45,67_AL_.jpg",
        title = "The Lord of the Rings: The Fellowship of the Ring",
        year = 2001
    ),
    ExploreMovieItem(
        bigImage = "https://m.media-amazon.com/images/M/MV5BOGQzZTBjMjQtOTVmMS00NGE5LWEyYmMtOGQ1ZGZjNmRkYjFhXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_QL75_UX380_CR0,6,380,562_.jpg",
        description = "The crew of a commercial spacecraft encounter a deadly lifeform after investigating an unknown transmission.",
        genre = listOf("Horror", "Sci-Fi"),
        id = "top53",
        image = "https://m.media-amazon.com/images/M/MV5BOGQzZTBjMjQtOTVmMS00NGE5LWEyYmMtOGQ1ZGZjNmRkYjFhXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_QL75_UX380_CR0,6,380,562_.jpg",
        imdbLink = "https://www.imdb.com/title/tt0078748",
        imdbid = "tt0078748",
        rank = 53,
        rating = "8.5",
        thumbnail = "https://m.media-amazon.com/images/M/MV5BOGQzZTBjMjQtOTVmMS00NGE5LWEyYmMtOGQ1ZGZjNmRkYjFhXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_UX45_CR0,0,45,67_AL_.jpg",
        title = "Alien",
        year = 1979
    ),
    ExploreMovieItem(
        bigImage = "https://m.media-amazon.com/images/M/MV5BY2I4MmM1N2EtM2YzOS00OWUzLTkzYzctNDc5NDg2N2IyODJmXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_QL75_UX380_CR0,4,380,562_.jpg",
        description = "With the aid of a wealthy erratic tippler, a dewy-eyed tramp who has fallen in love with a sightless flower girl accumulates money to be able to help her medically.",
        genre = listOf("Comedy", "Drama", "Romance"),
        id = "top54",
        image = "https://m.media-amazon.com/images/M/MV5BY2I4MmM1N2EtM2YzOS00OWUzLTkzYzctNDc5NDg2N2IyODJmXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_QL75_UX380_CR0,4,380,562_.jpg",
        imdbLink = "https://www.imdb.com/title/tt0021749",
        imdbid = "tt0021749",
        rank = 54,
        rating = "8.5",
        thumbnail = "https://m.media-amazon.com/images/M/MV5BY2I4MmM1N2EtM2YzOS00OWUzLTkzYzctNDc5NDg2N2IyODJmXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX45_CR0,0,45,67_AL_.jpg",
        title = "City Lights",
        year = 1931
    )
)

val trailers: List<MovieTrailer> = listOf(
    MovieTrailer(
        image = "https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_QL75_UX380_CR0,1,380,562_.jpg",
        name = "Trailer 1",
        duration = "1m 25s",
        state = "Update"
    ),
    MovieTrailer(
        image = "https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDItYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_QL75_UX380_CR0,0,380,562_.jpg",
        name = "Trailer 2: Final",
        duration = "1m 45s",
        state = "Update"
    )
)
 val comments: List<UserComment> = listOf(
     UserComment(
         userName = "User 1",
         comment = "Comment 1",
         time = 2
     ),
     UserComment(
         userName = "User 2",
         comment = "Comment 2",
         time = 3
     ),
     UserComment(
         userName = "User 3",
         comment = "Comment 3",
         time = 3
     ),
     UserComment(
         userName = "User 4",
         comment = "Comment 4",
         time = 4
     )
     ,UserComment(
         userName = "User 5",
         comment = "Comment 5",
         time = 5
     )
 )
