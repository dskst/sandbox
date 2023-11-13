fn main() {
    let x = 12;
    let a = 12u8;
    let b = 4.3;
    let bv = true;
    let t = (13, false);
    let sentence = "hello world!";
    println!(
        "{} {} {} {} {} {} {}",
        x, a, b, bv, t.0, t.1, sentence
    )
}
