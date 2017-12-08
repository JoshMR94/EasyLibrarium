/**
 * Author:  joshmr94
 * Created: 29-jun-2017
 */

/** GENEROS **/

INSERT INTO public.genre(
	id, name)
	VALUES (1, 'Comedia');
INSERT INTO public.genre(
	id, name)
	VALUES (2, 'Drama');
INSERT INTO public.genre(
	id, name)
	VALUES (3, 'Horror');
INSERT INTO public.genre(
	id, name)
	VALUES (4, 'Realismo Literario');
INSERT INTO public.genre(
	id, name)
	VALUES (5, 'Novela Romántica');
INSERT INTO public.genre(
	id, name)
	VALUES (6, 'Sátira');
INSERT INTO public.genre(
	id, name)
	VALUES (7, 'Tragedia');
INSERT INTO public.genre(
	id, name)
	VALUES (8, 'Tragicomedia');
INSERT INTO public.genre(
	id, name)
	VALUES (9, 'Fantasía');
INSERT INTO public.genre(
	id, name)
	VALUES (10, 'Mitología');
INSERT INTO public.genre(
	id, name)
	VALUES (11, 'Novela');

/** AUTORES **/
INSERT INTO public.author(
	id, birth_date, description, name, surname)
	VALUES (1, '29/09/1547', 'Está considerado la máxima figura de la literatura española y es universalmente conocido por haber escrito El ingenioso Hidalgo don Quijote de la Mancha (conocida habitualmente como el Quijote)', 'Miguel', 'de Cervantes Saavedra');
INSERT INTO public.author(
	id, birth_date, description, name, surname)
	VALUES (2, '31/07/1965', 'Conocida como J.K. Rowling, es la autora de la serie de libros Harry Potter, que han superado los 450 millones de ejemplares vendidos.', 'Joanne', 'Rowling');
INSERT INTO public.author(
	id, birth_date, description, name, surname)
	VALUES (3, '03/01/1893', 'Escritor, poeta, filólogo, lingüista y profesor universitario británico, conocido principalmente por ser el autor de las novelas clásicas de fantasía heroica El hobbit y El Señor de los Anillos.', 'John Ronald Reuel', 'Tolkien');


/** LIBROS **/

INSERT INTO public.book(
	id, isbn, editorial, publication_date, rate, title)
	VALUES (1, '9780805511963', 'Juan de la Cuesta', '01/01/1605', 7, 'Don Quijote de la Mancha');
INSERT INTO public.book(
	id, isbn, editorial, publication_date, rate, title)
	VALUES (2, '9711232314556', 'Salamandra', '01/01/1998', 8, 'Harry Potter y la Piedra Filosofal');
INSERT INTO public.book(
	id, isbn, editorial, publication_date, rate, title)
	VALUES (3, '9126790345670', 'Ediciones Minotauro', '01/01/1978', 9, 'El Señor de los Anillos: La Comunidad del Anillo');

/** USUARIOS **/
INSERT INTO public.luser(
	id, description, email, password, usertype, username)
	VALUES (1, 'administrador del sistema easylibrarium', 'admin@easylibrarium.com', 'admin', 0, 'admin');
INSERT INTO public.luser(
	id, description, email, password, usertype, username)
	VALUES (2, 'me gustan las cosas de leer y tal', 'joshua@gmail.com', 'joshua123', 1, 'joshuser');

/** Relacion LIBROS AUTORES **/
INSERT INTO public.books_author(author_id, book_id)
	VALUES (1, 1);
INSERT INTO public.books_author(author_id, book_id)
	VALUES (2, 2);
INSERT INTO public.books_author(author_id, book_id)
	VALUES (3, 3);

/** Relacion LIBROS GENEROS **/ 
INSERT INTO public.books_genre(
	genre_id, book_id)
	VALUES (11, 1);
INSERT INTO public.books_genre(
	genre_id, book_id)
	VALUES (9, 2);
INSERT INTO public.books_genre(
	genre_id, book_id)
	VALUES (9, 3);