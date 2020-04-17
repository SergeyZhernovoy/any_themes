package ru.bloch.no_construct;

/**Здесь явный запрет на инстанцирование класса.
 * @author Sergey Zhernovoy
 */
public final class Message {
    private final String TITLE = "Head";
    private Message() {
        new AssertionError();
    }

    public static final Message create() {
        return new Message();
    }

    public String getTitle() {
        return TITLE;
    }

    @Override
    public String toString() {

        return "Message{" +
                "TITLE='" + TITLE + '\'' +
                '}';
    }
}
