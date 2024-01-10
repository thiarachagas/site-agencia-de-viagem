using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace DreamTravel.Models
{
    [Table("passagem")]
    public class Passagem
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [Column("id")]
        public int Id { get; set; }

        [Column("origem")]
        public string Origem { get; set; }

        [DataType(DataType.Date)]
        [Column("data_partida")]
        public DateTime DataPartida { get; set; }

        [Column("fk_destino_id")]
        public int DestinoId { get; set; }
        public Destino Destino { get; set; }

        [Column("fk_companhia_aerea_id")]
        public int CompanhiaAereaId { get; set; }
        public CompanhiaAerea CompanhiaAerea { get; set; }

        [Column("fk_promocao_id")]
        public int? PromocaoId { get; set; }
        public Promocao? Promocao { get; set; }
    }
}
