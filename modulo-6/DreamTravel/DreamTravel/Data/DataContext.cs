using DreamTravel.Models;
using Microsoft.EntityFrameworkCore;

namespace DreamTravel.Data
{
    public class DataContext : DbContext
    {
        public DbSet<Destino> Destinos { get; set; }

        public DbSet<Promocao> Promocoes { get; set; }

        public DbSet<CompanhiaAerea> CompanhiasAereas { get; set; }

        public DbSet<Passagem> Passagens { get; set; }

        public DataContext(DbContextOptions<DataContext> options): base(options)
        {
        }
    }
}
