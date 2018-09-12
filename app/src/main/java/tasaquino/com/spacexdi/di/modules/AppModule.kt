package tasaquino.com.spacexdi.di.modules

import org.kodein.di.Kodein

val appModule = Kodein.Module("appDiModule") {
    import(networkingModule)
    import(rocketsSourceModule)
    import(rocketsPresenterModule)
}