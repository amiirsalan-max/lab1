package aod.lab1;
/**
 * Interface som beskriver vad en lista ska kunna göra.
 *
 * @author Abdisalan Mahad Omar
 * @date 2026-04-10
 */
public interface List<T> {

    // Lägger till element sist
    void add(T data);

    // Lägger till element på en viss position
    void add(T data, int index);

    // Hämtar element på index
    T get(int index);

    // Ändrar element på index
    void set(T data, int index);

    // Tar bort sista elementet
    void remove();

    // Tar bort element på index
    void remove(int index);

    // Returnerar antal element
    int size();

    // Tömmer listan
    void clear();
}