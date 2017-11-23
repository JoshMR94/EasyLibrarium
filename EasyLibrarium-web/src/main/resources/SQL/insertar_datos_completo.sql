/**
 * Author:  joshmr94
 * Created: 29-jun-2017
 */

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
	id, isbn, category, editorial, genre, publication_date, title)
	VALUES (1, '9780805511963', 'Todos los públicos', 'Juan de la Cuesta', 'Novela', '01/01/1605', 'Don Quijote de la Mancha');
INSERT INTO public.book(
	id, isbn, category, editorial, genre, publication_date, title)
	VALUES (2, '9711232314556', 'Todos los públicos', 'Salamandra', 'Novela fantástica', '01/01/1998', 'Harry Potter y la Piedra Filosofal');
INSERT INTO public.book(
	id, isbn, category, editorial, genre, publication_date, title)
	VALUES (3, '9126790345670', 'Todos los públicos', 'Ediciones Minotauro', 'Novela fantástica épica', '01/01/1978', 'El Señor de los Anillos: La Comunidad del Anillo');

/** Relacion LIBROS AUTORES **/
INSERT INTO public.books_author(author_id, book_id)
	VALUES (1, 1);
INSERT INTO public.books_author(author_id, book_id)
	VALUES (2, 2);
INSERT INTO public.books_author(author_id, book_id)
	VALUES (3, 3);

/** Relacion LIBROS USUARIOS **/ 