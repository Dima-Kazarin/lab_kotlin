interface Vehicle {
    val id: Int
    val brand: String
    val model: String
    val year: Int
    val mileage: Double

    fun startEngine(): String
    fun stopEngine(): String
    fun displayInfo(): String
}

abstract class BaseVehicle(
    override val id: Int,
    override val brand: String,
    override val model: String,
    override val year: Int,
    override var mileage: Double
) : Vehicle {

    init {
        require(year > 1885) { "Year must be greater than 1885" }
        require(mileage >= 0) { "Mileage cannot be negative" }
    }

    override fun startEngine(): String {
        return "$brand $model engine started."
    }

    override fun stopEngine(): String {
        return "$brand $model engine stopped."
    }

    override fun displayInfo(): String {
        return "ID: $id, Brand: $brand, Model: $model, Year: $year, Mileage: $mileage"
    }
}

class Car(
    id: Int,
    brand: String,
    model: String,
    year: Int,
    mileage: Double,
    val numberOfDoors: Int
) : BaseVehicle(id, brand, model, year, mileage) {

    override fun displayInfo(): String {
        return super.displayInfo() + ", Number of doors: $numberOfDoors"
    }
}

class Truck(
    id: Int,
    brand: String,
    model: String,
    year: Int,
    mileage: Double,
    val loadCapacity: Double
) : BaseVehicle(id, brand, model, year, mileage) {

    override fun displayInfo(): String {
        return super.displayInfo() + ", Load capacity: $loadCapacity kg"
    }
}

class Bus(
    id: Int,
    brand: String,
    model: String,
    year: Int,
    mileage: Double,
    val seatingCapacity: Int
) : BaseVehicle(id, brand, model, year, mileage) {

    override fun displayInfo(): String {
        return super.displayInfo() + ", Seating capacity: $seatingCapacity"
    }
}

fun validateVehicle(vehicle: Vehicle) {
    require(vehicle.mileage >= 0) { "Mileage cannot be negative" }
    println("${vehicle.displayInfo()} is valid.")
}

fun main() {
    val car = Car(id = 1, brand = "Toyota", model = "Corolla", year = 2020, mileage = 15000.0, numberOfDoors = 4)
    val truck = Truck(id = 2, brand = "Volvo", model = "FH", year = 2019, mileage = 50000.0, loadCapacity = 18000.0)
    val bus = Bus(id = 3, brand = "Mercedes-Benz", model = "Sprinter", year = 2021, mileage = 10000.0, seatingCapacity = 20)

    try {
        validateVehicle(car)
        validateVehicle(truck)
        validateVehicle(bus)

        println(car.startEngine())
        println(car.displayInfo())
        println(car.stopEngine())

        println(truck.startEngine())
        println(truck.displayInfo())
        println(truck.stopEngine())

        println(bus.startEngine())
        println(bus.displayInfo())
        println(bus.stopEngine())
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}
