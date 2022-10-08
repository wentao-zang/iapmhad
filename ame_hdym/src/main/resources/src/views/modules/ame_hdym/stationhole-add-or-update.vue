<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="٤װ۹׼ߗ-X׸Ѫ" prop="theoryx">
      <el-input v-model="dataForm.theoryx" placeholder="٤װ۹׼ߗ-X׸Ѫ"></el-input>
    </el-form-item>
    <el-form-item label="" prop="theoryy">
      <el-input v-model="dataForm.theoryy" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="theoryz">
      <el-input v-model="dataForm.theoryz" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="theorya">
      <el-input v-model="dataForm.theorya" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="theoryb">
      <el-input v-model="dataForm.theoryb" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="theoryc">
      <el-input v-model="dataForm.theoryc" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="٤װ۹׼ߗʵ܊X׸Ѫ" prop="actualx">
      <el-input v-model="dataForm.actualx" placeholder="٤װ۹׼ߗʵ܊X׸Ѫ"></el-input>
    </el-form-item>
    <el-form-item label="" prop="actualy">
      <el-input v-model="dataForm.actualy" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="actualz">
      <el-input v-model="dataForm.actualz" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="actuala">
      <el-input v-model="dataForm.actuala" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="actualb">
      <el-input v-model="dataForm.actualb" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="actualc">
      <el-input v-model="dataForm.actualc" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="time">
      <el-input v-model="dataForm.time" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          theoryx: '',
          theoryy: '',
          theoryz: '',
          theorya: '',
          theoryb: '',
          theoryc: '',
          actualx: '',
          actualy: '',
          actualz: '',
          actuala: '',
          actualb: '',
          actualc: '',
          time: ''
        },
        dataRule: {
          theoryx: [
            { required: true, message: '٤װ۹׼ߗ-X׸Ѫ不能为空', trigger: 'blur' }
          ],
          theoryy: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          theoryz: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          theorya: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          theoryb: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          theoryc: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          actualx: [
            { required: true, message: '٤װ۹׼ߗʵ܊X׸Ѫ不能为空', trigger: 'blur' }
          ],
          actualy: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          actualz: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          actuala: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          actualb: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          actualc: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          time: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/ame_hdym/stationhole/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.theoryx = data.stationhole.theoryx
                this.dataForm.theoryy = data.stationhole.theoryy
                this.dataForm.theoryz = data.stationhole.theoryz
                this.dataForm.theorya = data.stationhole.theorya
                this.dataForm.theoryb = data.stationhole.theoryb
                this.dataForm.theoryc = data.stationhole.theoryc
                this.dataForm.actualx = data.stationhole.actualx
                this.dataForm.actualy = data.stationhole.actualy
                this.dataForm.actualz = data.stationhole.actualz
                this.dataForm.actuala = data.stationhole.actuala
                this.dataForm.actualb = data.stationhole.actualb
                this.dataForm.actualc = data.stationhole.actualc
                this.dataForm.time = data.stationhole.time
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/ame_hdym/stationhole/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'theoryx': this.dataForm.theoryx,
                'theoryy': this.dataForm.theoryy,
                'theoryz': this.dataForm.theoryz,
                'theorya': this.dataForm.theorya,
                'theoryb': this.dataForm.theoryb,
                'theoryc': this.dataForm.theoryc,
                'actualx': this.dataForm.actualx,
                'actualy': this.dataForm.actualy,
                'actualz': this.dataForm.actualz,
                'actuala': this.dataForm.actuala,
                'actualb': this.dataForm.actualb,
                'actualc': this.dataForm.actualc,
                'time': this.dataForm.time
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
