Table: librarian
Columns:
- id (integer, primary key, auto-increment)
- username (string, unique)
- password (string)

Table: member
Columns:
- id (integer, primary key, auto-increment)
- username (string, unique)
- password (string)

Table: book
Columns:
- id (integer, primary key, auto-increment)
- title (string)
- author (string)
- isbn (string)
- status (enum: AVAILABLE, BORROWED)

Table: book_transaction
Columns:
- id (integer, primary key, auto-increment)
- book_id (integer, foreign key to book.id)
- member_id (integer, foreign key to member.id)
- transaction_type (enum: BORROW, RETURN)
- transaction_date (timestamp)
